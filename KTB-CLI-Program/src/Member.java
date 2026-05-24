import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Member {

    // 공통 스캐너 객체
    Scanner sc = new Scanner(System.in);

    protected MemberInfo memberInfo;

    Member(MemberInfo memberInfo){
        this.memberInfo = memberInfo;
    }


    // 현재 시간 출력 메소드
    protected String timeStamp(){

        // 현재 시간
        LocalTime timeNow = LocalTime.now();

        // 포맷
        DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("HH시 mm분");

        return timeNow.format(formattedTime);
    }

    // 출근 메소드
    void goToWork(String memberName){
        // 현재 시간 변수에 담기
        String nowTime = timeStamp();

        if(memberInfo.members.contains(memberName)){
            System.out.println(memberName+"님(일반 직원), " + nowTime + " 출근 처리 되었습니다.");
            memberInfo.startWorkTime.put(memberName,nowTime);
        } else {
            System.out.println("해당 직원이 존재하지 않습니다.");
        }

    }

    //퇴근 메소드
    void goToHome(String memberName) {

        if (memberInfo.members.contains(memberName)) {
            if(memberInfo.startWorkTime.get(memberName)==null){
                System.out.println("출근 기록이 없습니다. 다시 확인하세요.");
                System.out.println("=======================================");

            } else {
                System.out.println(memberName + "님(일반 직원), " + timeStamp() + " 퇴근 처리 되었습니다.");
                System.out.println("출근 시간: " + memberInfo.startWorkTime.get(memberName));
            }
        } else {
            System.out.println("해당 직원이 존재하지 않습니다.");

        }
    }

    // 직원 조회 메소드
    void searchMem(){

        System.out.println("=============== 직원 목록 ===============");

        int id = 0;

        for (int i = 0 ; i < memberInfo.members.size() ; i ++){
            System.out.println((id + 1) + ". " + memberInfo.members.get(id));
            id ++;
        }


    }

    // 할 일 리스트 조회 메소드
    void todo(){

        System.out.println("============ 할 일 조회 메뉴 ============");

        System.out.print("이름을 입력하세요 → ");

        String todoName = sc.next();

        if (!memberInfo.todoList.containsKey(todoName)){
            System.out.println("해당 직원이 없습니다.");
            Main.EmployMenu();
        } else {
            if(memberInfo.todoList.get(todoName).isEmpty()){
                System.out.println("할 일이 없습니다!");
            } else {
                System.out.println(todoName + "님의 할 일 입니다.");

                for(String work : memberInfo.todoList.get(todoName)){
                    System.out.println("- " + work);
                }
            }
        }

    }




}
