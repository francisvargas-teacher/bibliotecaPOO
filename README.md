# bibliotecaPOO
MediaItem (abstrata, NOVA)
Atributos: id, title, year, totalCopies, availableCopies
Métodos: borrow(), returnItem()

Base polimórfica para todos os itens emprestáveis.

Book (agora estende MediaItem)
Atributos extras: author, isbn
Regras originais mantidas para isbn e cópias.

Magazine (NOVA, estende MediaItem)
Atributos extras: issue (edição).

Dvd (NOVA, estende MediaItem)
Atributos extras: durationMinutes, regionFree.

Member (agora abstrata)
Atributos: id, name, email, active, penalty (BigDecimal)
Métodos: canBorrow(), addPenalty(BigDecimal), clearPenalty()
+ loanDaysFor(MediaItem) (método abstrato — polimorfismo para prazo)

Student (NOVA, estende Member)
Regra polimórfica exemplo: loanDaysFor → 7 dias Book/Magazine, 3 dias Dvd.

Professor (NOVA, estende Member)
Regra polimórfica exemplo: loanDaysFor → 14 dias Book, 7 Magazine, 5 Dvd.

Loan (mantida)
Atributos: id, item: MediaItem, member, loanDate, dueDate, returnDate
Métodos: markReturned(LocalDate), isOverdue(LocalDate), getDaysOverdue(LocalDate)

dueDate passa a ser calculada com member.loanDaysFor(item) quando days <= 0.

Catalog (adaptada)
Estrutura interna: Map<String, MediaItem>
Métodos: addItem(MediaItem), findById(String), searchByTitle(String), increaseStock(String,int), decreaseStock(String,int)

LoanService (adaptada)
Métodos: borrow(String itemId, Member, LocalDate loanDate, int days), returnItem(String loanId, LocalDate returnDate)
Regras: usa Catalog, valida member.canBorrow(), controla estoque via MediaItem.borrow/returnItem, e calcula dueDate por polimorfismo.

Reservation (NOVA)
Atributos: id, item: MediaItem, member, reservedAt, expiresAt, status (enum)
Métodos: expire(), fulfill(), cancel().


classDiagram
direction LR
class MediaItem {
  <<abstract>>
  -id:String
  -title:String
  -year:int
  -totalCopies:int
  -availableCopies:int
  +borrow():void
  +returnItem():void
}
MediaItem <|-- Book
MediaItem <|-- Magazine
MediaItem <|-- Dvd

class Book { -author:String; -isbn:String }
class Magazine { -issue:int }
class Dvd { -durationMinutes:int; -regionFree:boolean }

class Member {
  <<abstract>>
  -id:String
  -name:String
  -email:String
  -active:boolean
  -penalty:BigDecimal
  +canBorrow():boolean
  +addPenalty(value:BigDecimal):void
  +clearPenalty():void
  +loanDaysFor(item:MediaItem):int
}
Member <|-- Student
Member <|-- Professor

class Loan {
  -id:String
  -item:MediaItem
  -member:Member
  -loanDate:LocalDate
  -dueDate:LocalDate
  -returnDate:LocalDate
  +markReturned(when:LocalDate):void
  +isOverdue(ref:LocalDate):boolean
  +getDaysOverdue(ref:LocalDate):long
}

class Catalog {
  -byId:Map~String,MediaItem~
  +addItem(item:MediaItem):void
  +findById(id:String):Optional~MediaItem~
  +searchByTitle(term:String):List~MediaItem~
  +increaseStock(id:String,q:int):void
  +decreaseStock(id:String,q:int):void
}

class LoanService {
  -catalog:Catalog
  +borrow(itemId:String, m:Member, d:LocalDate, days:int):Loan
  +returnItem(loanId:String, d:LocalDate):Loan
}

class Reservation {
  -id:String
  -item:MediaItem
  -member:Member
  -reservedAt:LocalDate
  -expiresAt:LocalDate
  -status:ReservationStatus
  +expire():void
  +fulfill():void
  +cancel():void
}

class FineCalculator {
  -dailyRate:BigDecimal
  +calculate(loan:Loan, ref:LocalDate):BigDecimal
}


FineCalculator (mantida)
Construtor: dailyRate (BigDecimal)
Método: calculate(Loan, LocalDate) → max(0, diasAtraso) * dailyRate.
