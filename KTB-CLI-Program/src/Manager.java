

public class Manager extends Member{


    Manager(MemberInfo memberInfo) {
        super(memberInfo);
    }

    @Override
    // 출근 메소드
    void goToWork(String memberName){
        // 현재 시간 변수에 담기
        String nowTime = super.timeStamp();

        if(memberInfo.managers.contains(memberName)){
            System.out.println(memberName+" 매니저님, " + nowTime + " 출근 처리 되었습니다.");
            memberInfo.startWorkTime.put(memberName,nowTime);
        } else {
            System.out.println("해당 매니저가 존재하지 않습니다.");
        }

    }

    @Override
    //퇴근 메소드
    void goToHome(String memberName) {

        if (memberInfo.members.contains(memberName)) {
            if(memberInfo.startWorkTime.get(memberName)==null){
                System.out.println("출근 기록이 없습니다. 다시 확인하세요.");
                System.out.println("=======================================");

            } else {
                System.out.println(memberName + " 매니저님 " + timeStamp() + " 퇴근 처리 되었습니다.");
                System.out.println("출근 시간: " + memberInfo.startWorkTime.get(memberName));
            }
        } else {
            System.out.println("해당 매니저가 존재하지 않습니다.");

        }
    }

    // 모든 직원 조회
    void allMemSearch(){

        int idManager = 0;

        System.out.println("=============== 매니저 목록 ===============");
        for (int i = 0 ; i < memberInfo.managers.size() ; i ++){
            System.out.println((idManager + 1) + ". " + memberInfo.managers.get(idManager));
            idManager ++;
        }

        super.searchMem();

    }

    // 할 일 할당 메소드
    void assignWork(){

        super.searchMem();

        System.out.print("할 일을 할당할 직원 이름을 입력하세요 → ");

        String assignName = super.sc.next();

        if(memberInfo.members.contains(assignName)){

            for (TodoEnum todoEnum : TodoEnum.values()){
                System.out.println(todoEnum.menuNum +". " + todoEnum.menuName);
            };

            System.out.println("=======================================");
            System.out.print("할당 할 일의 번호을 고르세요 → ");

            String todo = super.sc.next();

            int todoNum;

            try {
                todoNum = Integer.parseInt(todo);
                TodoEnum todoName = TodoEnum.getTodo(todoNum);

                if(todoName == null){
                    System.out.println("잘못 고르셨습니다.");
                    System.out.println("=======================================");
                }else {
                    switch (todoName){
                        case WRITE_TIL, HW, CONNECT_ZEP, MENTORING: {
                            memberInfo.todoList.get(assignName).add(todoName.getMenuName());
                            break;
                        }
                    }
                }
            } catch (NumberFormatException e){
                System.out.println("숫자를 입력하세요. 처음으로 돌아갑니다.");
                System.out.println("=======================================");
            }
        } else {
            System.out.println("해당 직원이 존재하지 않습니다.");
            System.out.println("=======================================");
        }


    }


}
