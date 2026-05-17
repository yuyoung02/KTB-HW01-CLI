import java.util.*;

public class PartTime extends Member{

    // 할 일
    HashMap<String, List<String>> todoList = new HashMap<>();

    // 할 일 초기 세팅
    void setTodo(){
        for (String memName : super.members){
            List<String> works = new ArrayList<>();
            todoList.put(memName,works);
        }
    }

    // 할 일 리스트 조회 메소드
    void todo(){

        Scanner sc = new Scanner(System.in);

        System.out.println("============ 할 일 조회 메뉴 ============");

        System.out.print("이름을 입력하세요 → ");

        String todoName = sc.next();

        if (!todoList.containsKey(todoName)){
            System.out.println("해당 직원이 없습니다.");
            System.out.println("=======================================");
            Main.MainMenu();
        } else {
            if(todoList.get(todoName).isEmpty()){
                System.out.println("할 일이 없습니다!");
                System.out.println("=======================================");
            } else {
                System.out.println(todoName + "님의 할 일 입니다.");

                for(String work : todoList.get(todoName)){
                    System.out.println("- " + work);
                }
                System.out.println("=======================================");
            }
            Main.MainMenu();
        }

    }

}
