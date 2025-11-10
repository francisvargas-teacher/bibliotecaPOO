public class Reservation {
    private String id;
    private MediaItem item;
    private Member member;
    private LocalDate reservedAt;
    private LocalDate expiresAt;
    private Status status;
    public enum Status {
        ACTIVE,
        EXPIRED,
        FULFILLED,
        CANCELED
}

public Reservation(String id, MediaItem item, Member member, LocalDate reservedAt, LocalDate expiresAt) {
        this.id = id;
        this.item = item;
        this.member = member;
        this.reservedAt = reservedAt;
        this.expiresAt = expiresAt;
        this.status = Status.ACTIVE;
}

public String getId() {
    return id;
    }

public MediaItem getItem() {
    return item;
    }

public Member getMember() {
    return member;
    }

public LocalDate getReservedAt() {
    return reservedAt;
    }

public LocalDate getExpiresAt() {
    return expiresAt;
    }

public Status getStatus() {
    return status;
    
    }

public void expire() {
    if (status == Status.ACTIVE && LocalDate.now().isAfter(expiresAt)) {
        status = Status.EXPIRED;
        }
    }

public void fulfill() {
    if (status == Status.ACTIVE) {
        status = Status.FULFILLED;
     }
        
}
public void cancel() {
    if (status == Status.ACTIVE) {
        status = Status.CANCELED;
        }
    }
}
