import java.util.Random;

public class Notification implements Runnable{

    private final String[] notifications = {
            "[사내 방송] 오늘 하루도 근무 화이팅 !",
            "[사내 방송] 모두 출근 등록 하셨나요 ?",
            "[전체 공지] 출근 후 할 일을 꼭 확인하세요 !",
            "[전체 공지] 문의 사항을 관리자에게 연락 주세요 !",
            "[중요 공지] 퇴근 시 퇴근 등록 잊지 마세요 !",
            "[중요 공지] 출근 시 출근 등록 잊지 마세요 !",
            "[매니저 공지] 일반 직원에게 할 일 할당 해주세요 !",
            "[일반 직원 공지] 할 일 문의는 매니저 또는 관리자에게 연락 주세요 !"
    };

    @Override
    public void run() {

        Random random = new Random();
        int lastIndex = -1; // 방금 출력된 인덱스 기억하기
        boolean isFirst = true; //맨 처음 방송인지 체크

        try {
            while (!Thread.currentThread().isInterrupted()) {
                int index;

                do {
                    index = random.nextInt(notifications.length);
                } while (index == lastIndex);
                lastIndex = index;

                // 안내 출력
                System.out.println("\n" + notifications[index]);

                // 맨 처음 때는 방송만 출력
                if (isFirst) {
                    isFirst = false; // 두번째부터는 입력 유도선까지
                } else {
                    System.out.print("계속 입력하세요 → ");
                }

                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            System.out.println("[사내 방송] 방송 시스템을 종료합니다.");
        }
    }
}