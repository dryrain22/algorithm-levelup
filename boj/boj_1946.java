package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1946 {
    static class Applicant {
        int docs;
        int interview;

        public Applicant(int docs, int interview) {
            this.docs = docs;
            this.interview = interview;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            Applicant[] applicants = new Applicant[N];

            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int docs = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());

                applicants[j] = new Applicant(docs, interview);
            }

            Arrays.sort(applicants, (o1, o2) -> o1.docs - o2.docs);

            int answer = 1; // 첫 번째 지원자는 항상 선발
            int maxInterview = applicants[0].interview;

            for(int j = 1; j < N; j++) {
                if (applicants[j].interview < maxInterview) {
                    answer++;
                    maxInterview = applicants[j].interview;
                }
            }
            System.out.println(answer);
        }
    }
}
