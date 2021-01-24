package LittleProblems;

public class shots3 {
    public static void duel3d(int num){
        int B=1,C=2,D=3;
        int countBKills=0, countCKills=0, countDKills=0;
        double cChanceToKill=0,dChanceToKill=0;
        /*is just like the odd's = first one is 100% chance (pb)
        The second has an 80% chance (pc)
        The third has an 50% chance (pd)
         */
        double pc=0.8,pd=0.5;//pb=1
        boolean flag=true;
        for (int i = 1; i <= num; i++) {
            int[] q=getQueuq3();
            int first = q[1];

            switch (first) {
                case 1://B is first and B kills C
                    dChanceToKill = Math.random();//D fire
                    if (dChanceToKill < pd) {//D kills B
                        countDKills++;
                    } else {
                        countBKills++;//B kills D
                    }
                    break;

                case 2: //C is the first'and try to kill B
                    cChanceToKill = Math.random();
                    if (cChanceToKill < pc) {//C kills B,duel between C and D
                        flag = true;
                        while (flag) {
                            dChanceToKill = Math.random();//D fires
                            if (dChanceToKill < pd) {//C is dead
                                countDKills++;
                                flag = false;
                            } else {
                                cChanceToKill = Math.random();
                                if (cChanceToKill < pc) {//D is dead
                                    countCKills++;
                                    flag = false;
                                }
                            }
                        }
                    }
                    //c does not kill B, the triple duel B,C,D
                    else if (q[2] == B) {//B is the second, B kills C
                        dChanceToKill = Math.random();// D fire' try to kill B
                        if (dChanceToKill < pd) {//D kills B
                            countDKills++;
                        } else {//B kills D
                            countBKills++;
                        }
                    } else if (q[2] == D) {//D is the second , D dosnt fire, B kills C
                        dChanceToKill = Math.random();
                        if (dChanceToKill < pd) {//D kills B
                            countDKills++;
                        } else {// B kills D
                            countBKills++;
                        }
                    }
                    break;

                case 3://D is the first, D dosnt fire, B is second ,B kills C
                    if (q[2] == B) {
                        dChanceToKill = Math.random();//D fire
                        if (dChanceToKill < pd) {//D kills B
                            countDKills++;
                        } else {//B kills D
                            countBKills++;
                        }
                    } else {
                        if (q[2] == C) {//C is second , C try to kill B
                            cChanceToKill = Math.random();
                            if (cChanceToKill < pc) {//C kills B , duel between C and D
                                flag = true;
                                while (flag) {
                                    dChanceToKill = Math.random();//D fires
                                    if (dChanceToKill < pd) {//C is dead
                                        countDKills++;
                                        flag = false;
                                    } else {
                                        cChanceToKill = Math.random();//C fire
                                        if (cChanceToKill < pc) {//D is dead
                                            countCKills++;
                                            flag = false;
                                        }
                                    }
                                }
                            } else {//C dosnt kill B, B kills C
                                dChanceToKill = Math.random();//D fires
                                if (dChanceToKill < pd) {//D kills B
                                    countDKills++;
                                } else {//B kills D
                                    countBKills++;
                                }
                            }
                        }
                    }
                    break;
            }
        }
        double probB=(double)countBKills/num;
        double probC=(double)countCKills/num;
        double probD=(double)countDKills/num;
        System.out.println("probB = "+probB+", probC = "+probC+", probD = "+probD);
        System.out.println("sum = "+(probB+probC+probD));
    }

    private static int[] getQueuq3() {
    int[] q = {0,1,2,3};
        for (int i = 1; i < q.length; i++) {
            int j = (int)((Math.random()*3)+1);
            //swap for random
            int t = q[i];
            q[i]=q[j];
            q[j]=t;
        }
        return q;
    }


    public static void main(String[] args) {
        duel3d(3);

    }
}
