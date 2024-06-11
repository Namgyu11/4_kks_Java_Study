package CLI_Quest_01.music;

public class BackgroundMusic implements Runnable {
      private volatile boolean running = true;

      private int currentTrackIndex = 0;
      private final String[] musicTracks = {
              "♩ ♪ ♫ ♬ 현재 매장 음악: Track 1 - 아이유 - Blueming",
              "♩ ♪ ♫ ♬ 현재 매장 음악: Track 2 - BTS - Dynamite",
              "♩ ♪ ♫ ♬ 현재 매장 음악: Track 3 - LUCY - 떼굴떼굴",
              "♩ ♪ ♫ ♬ 현재 매장 음악: Track 4 - 검정치마 - 미는 남자",
              "♩ ♪ ♫ ♬ 현재 매장 음악: Track 5 - 맥도날드 - 참깨 빵"
      };

      @Override
      public void run() {
            while (running) {
                  System.out.println("\n" + musicTracks[currentTrackIndex]);
                  try {
                        Thread.sleep(8000); // 8초마다 음악 변경
                  } catch (InterruptedException e) {
                        // 인터럽트가 발생해도 running 플래그를 확인
                        if (!running) {
                              System.out.println("음악 재생이 중단되었습니다.");
                              return;
                        }
                  }
            }
      }

      public void stopMusic() {
            running = false;
            Thread.currentThread().interrupt(); // 스레드 인터럽트로 대기 상태에서 빠져나옴
      }

      public synchronized void nextTrack() {
            currentTrackIndex = (currentTrackIndex + 1) % musicTracks.length;
            System.out.println("\n" + musicTracks[currentTrackIndex]);
      }
      //주석 추가
}
