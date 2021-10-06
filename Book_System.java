class Book{
    public Book(String name,int page){
        this.name=name;
        if(page>=200){
            this.page=page;
        }else{
            page=200;
        } 
    }
    public void set_name(String name){
        this.name=name;
    }
    public boolean judgePage(int page){
        if(page>=200){
            this.page=page;
            return true;//表示设置成功
        }
        this.page=200;
        return false;//设置失败
    }
    public void detail(){
        System.out.println(name+"的页数是"+page);
    }
    private String name;
    private int page;
};

class BookTest{
    private static Book bk;
    public static void Book_init(){
        bk=new Book("算法竞赛进阶指南",666);
    }
    public static void display(){
        bk.detail();
    }
}

public class Book_System{
    public static void main(String[] args) {
        BookTest.Book_init();
        BookTest.display();
    }
}