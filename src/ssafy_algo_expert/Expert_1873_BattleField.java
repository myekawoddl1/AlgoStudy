package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

문자	의미
.	평지(전차가 들어갈 수 있다.)
*	벽돌로 만들어진 벽
#	강철로 만들어진 벽
-	물(전차는 들어갈 수 없다.)
^	위쪽을 바라보는 전차(아래는 평지이다.)
v	아래쪽을 바라보는 전차(아래는 평지이다.)
<	왼쪽을 바라보는 전차(아래는 평지이다.)
>	오른쪽을 바라보는 전차(아래는 평지이다.)
다음 표는 사용자가 넣을 수 있는 입력의 종류를 나타낸다.

문자	동작
U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
 */
@SuppressWarnings("Duplicates")
public class Expert_1873_BattleField {
    static class Robot{
        int x, y;
        char dir;

        public Robot() {
        }

        public Robot(int x, int y, char dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    static int T;
    static char[][] map;
    static Robot robot;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            map = new char[H][W];

            boolean isExist = false;

            for(int i = 0; i < H; i++){
                st = new StringTokenizer(br.readLine());
                map[i] = st.nextToken().toCharArray();
                if(!isExist){
                    for(int j = 0; j < map[i].length; j++){
                        switch (map[i][j]){
                            case '^':
                                robot = new Robot(j, i, '^');
                                isExist = true;
                                break;
                            case 'v':
                                robot = new Robot(j, i, 'v');
                                isExist = true;
                                break;
                            case '<':
                                robot = new Robot(j, i, '<');
                                isExist = true;
                                break;
                            case '>':
                                robot = new Robot(j, i, '>');
                                isExist = true;
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            char command[] = st.nextToken().toCharArray();

            for(int i = 0; i < N; i++){
                switch (command[i]){
                    case 'U':
                        robot.dir = '^';
                        if(robot.y > 0){
                            if(map[robot.y - 1][robot.x] == '.'){
                                map[robot.y][robot.x] = '.';
                                robot.y--;
                            }
                        }
                        break;
                    case 'D':
                        robot.dir = 'v';
                        if(robot.y < H - 1){
                            if(map[robot.y + 1][robot.x] == '.'){
                                map[robot.y][robot.x] = '.';
                                robot.y++;
                            }
                        }
                        break;
                    case 'L':
                        robot.dir = '<';
                        if(robot.x > 0){
                            if(map[robot.y][robot.x - 1] == '.'){
                                map[robot.y][robot.x] = '.';
                                robot.x--;
                            }
                        }
                        break;
                    case 'R':
                        robot.dir = '>';
                        if(robot.x < W - 1){
                            if(map[robot.y][robot.x + 1] == '.'){
                                map[robot.y][robot.x] = '.';
                                robot.x++;
                            }
                        }
                        break;
                    case 'S':
                        int missileY = robot.y;
                        int missileX = robot.x;
                        switch (robot.dir){
                            case '^':
                                missileY--;
                                for(;missileY >= 0; missileY--){
                                    if(map[missileY][missileX] == '*' || map[missileY][missileX] == '#'){
                                        if(map[missileY][missileX] == '*'){
                                            map[missileY][missileX] = '.';
                                        }
                                        break;
                                    }
                                }
                                break;
                            case 'v':
                                missileY++;
                                for(;missileY <= H - 1; missileY++){
                                    if(map[missileY][missileX] == '*' || map[missileY][missileX] == '#'){
                                        if(map[missileY][missileX] == '*'){
                                            map[missileY][missileX] = '.';
                                        }
                                        break;
                                    }
                                }
                                break;
                            case '<':
                                missileX--;
                                for(;missileX >= 0; missileX--){
                                    if(map[missileY][missileX] == '*' || map[missileY][missileX] == '#'){
                                        if(map[missileY][missileX] == '*'){
                                            map[missileY][missileX] = '.';
                                        }
                                        break;
                                    }
                                }
                                break;
                            case '>':
                                missileX++;
                                for(;missileX <= W - 1; missileX++){
                                    if(map[missileY][missileX] == '*' || map[missileY][missileX] == '#'){
                                        if(map[missileY][missileX] == '*'){
                                            map[missileY][missileX] = '.';
                                        }
                                        break;
                                    }
                                }
                                break;
                            default:
                                break;
                        }
                        break;
                }
            }
            map[robot.y][robot.x] = robot.dir;
            System.out.print("#" +  tc + " ");
            for(int i = 0; i < H; i++){
                System.out.println(map[i]);
            }
        }
    }
}
