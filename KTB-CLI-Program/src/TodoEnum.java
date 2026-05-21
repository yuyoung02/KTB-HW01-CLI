
// 할 일 목록
public enum TodoEnum {
    WRITE_TIL(1, "TIL 작성하기"),
    HW(2, "과제하기"),
    CONNECT_ZEP(3,"ZEP 접속하기"),
    MENTORING(4,"멘토링 진행하기");

    int menuNum;
    String menuName;

    private TodoEnum(int menuNum, String menuName){
        this.menuNum = menuNum;
        this.menuName = menuName;
    }

    public int getMenuNum(){
        return menuNum;
    }

    public String getMenuName(){
        return menuName;
    }

    public static TodoEnum getTodo(int num){

        for(TodoEnum todoEnum : values()){
            if(todoEnum.menuNum == num){
                return todoEnum;
            }
        }

        return null;
    }
}
