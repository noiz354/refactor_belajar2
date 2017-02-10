package norman.unknown;

import norman.template.Template2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created @author normansyahputa  on 12/18/16.
 * https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/recitation-videos/recitation-20-dynamic-programming-blackjack/
 * <p>
 * cannot be proof.
 */
public class BlackJack extends Template2 {
    int n = -1, c_[], dp[];

    public BlackJack() {
        super("BlackJack", "BlackJack", LINUX, true);
    }

    @Override
    public void doSomething() {
        String line = null;
        try {
            while ((line = getInput2().readLine()) != null && !line.equals("")) {
                String[] strInput = line.split(" ");
                c_ = new int[strInput.length];
                for (int i = 0; i < strInput.length; i++) {
                    c_[i] = Integer.parseInt(strInput[i]);
                }

                n = c_.length;
                System.out.println(BJ(0));

                // based on explanation not worked
                dp = new int[52];
                BJ();
//                System.out.println(Arrays.toString(dp));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * somehow explanation is good but to code it, it's getting difficult
     */
    void BJ() {
        for (int j = n - 1; j >= 0; j--) {
            List<Integer> choices = new ArrayList<>();
            choices.add(0);

            for (int h = 0; h < n - j; h++) {
                RoundOutcome o = roundOutcome(j, h);
                choices.add(o.earning + dp[j + o.cardPlay]);
            }

            int result = -1;
            for (int k = 0; k < choices.size(); k++) {
                result = Math.max(choices.get(k), result);
            }
            dp[j] = result;
        }
    }

    RoundOutcome roundOutcome(int i, int h) {
        return new RoundOutcome(6, 1);
    }

    int BJ(int i) {
        if (n - 1 < 4)
            return 0; // since there are not enough cards
        List<Integer> options = new ArrayList<>();
        for (int p = 2; p < n - i - 2; p++) {
            // player’s cards by deal order (player, then dealer, then player)
            int player = c_[i] + c_[i + 2];
            for (int j = i + 4; j < i + p + 2; j++) {
                player += c_[j];
            }

            if (player > 21) {// bust
                options.add(-1 + BJ(i + p + 2));
            }

            int dealer = 0, d = 0;
            for (d = 2; d < n - i - p; d++) {
                dealer = c_[i + 1] + c_[i + 3];
                for (int j = i + p + 2; j < i + p + d; j++) {
                    dealer += c_[j];
                }
                if (dealer >= 17)
                    break;
            }

            if (dealer > 21)
                dealer = 0;

            options.add(Integer.valueOf(player).compareTo(Integer.valueOf(dealer)) + BJ(i + p + d));
        }
        int result = -1;
        for (int j = 0; j < options.size(); j++) {
            result = Math.max(options.get(j), result);
        }
        return result;
    }

    static class RoundOutcome {
        int cardPlay;
        int earning;

        public RoundOutcome(int cardPlay, int earning) {
            this.cardPlay = cardPlay;
            this.earning = earning;
        }
    }

}
