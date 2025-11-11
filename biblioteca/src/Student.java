public class Student extends Member{

    public boolean canBorrow(){
        if(this.penalty>0){
            System.out.println("Member With Penalty: "+this.penalty+" days");
            return false;
        }
        return true;
    }
    protected void addPenalty(){
        int randomInt = random.nextInt(1,10);
        penalty += randomInt;
        System.out.println("Penalty added to member: " + penalty+ " days");
    }

    protected void clearPenalty(){
        penalty = 0;
    }

    public void loadDaysFor(MediaItem item){
        int tipoItem = 0; // 1 = book | 2 = Magazine | 3 = Dvd

        try {
            tipoItem = (item.isbn) ? 1:0;
        }catch(Exception e){
            try{
                tipoItem = (item.issue) ? 2:0;
            }catch(Exception e2){
                tipoItem = 3;
            }
        }
    }

}
