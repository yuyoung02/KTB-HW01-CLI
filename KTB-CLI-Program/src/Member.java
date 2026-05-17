import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Member {

    // 직원 목록
    List<String> members = new ArrayList<>();

    // 출근 기록
    HashMap<String, String> startWorkTime = new HashMap<>();

    // 현재 시간 출력 메소드
    private String timeStamp(){

        // 현재 시간
        LocalTime timeNow = LocalTime.now();

        // 포맷
        DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("HH시 mm분");
        String formatedTimeNow = timeNow.format(formattedTime);

        return formatedTimeNow;
    }

    // 출근 메소드
    void goToWork(String memberName){

        if(members.contains(memberName)){
            System.out.println(memberName+"님, " + timeStamp() + " 출근 처리 되었습니다.");
            startWorkTime.put(memberName,timeStamp());
        } else {
            System.out.println("해당 직원이 존재하지 않습니다.");
        }

    }

    //퇴근 메소드
    void goToHome(String memberName) {

        if (members.contains(memberName)) {
            if(startWorkTime.get(memberName)==null){
                System.out.println("출근 기록이 없습니다. 다시 확인하세요.");
                System.out.println("=======================================");

                Main.MainMenu();
            } else {
                System.out.println(memberName + "님 " + timeStamp() + " 퇴근 처리 되었습니다.");
                System.out.println("출근 시간: " + startWorkTime.get(memberName));
            }
        } else {
            System.out.println("해당 직원이 존재하지 않습니다.");


        }
    }


    // 직원 조회 메소드
    void searchMem(){

        System.out.println("=============== 직원 목록 ===============");

        int id = 0;

        for (int i = 0 ; i < members.size() ; i ++){
            System.out.println((id + 1) + ". " + members.get(id));
            id ++;
        }

        System.out.println("=======================================");

    }


}
