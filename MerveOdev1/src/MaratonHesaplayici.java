public class MaratonHesaplayici {
    private String[] nameArray = {};
    private int[] timingArray = {};

    public MaratonHesaplayici setNames(String[] nameArray) {
        this.nameArray = nameArray;
        return this;
    }

    public MaratonHesaplayici setTimings(int[] timingArray) {
        this.timingArray = timingArray;
        return this;
    }

    public void printFirstTree() {
        int first = 0;
        int second = 0;
        int third = 0;
        for (int i = 0; i < timingArray.length; i++) {
            if (timingArray[i] < timingArray[first]) {
                third = second;
                second = first;
                first = i;
            } else if (timingArray[i] < timingArray[second]) {
                third = second;
                second = i;
            } else if (timingArray[i] < timingArray[third]) {
                third = i;
            }
        }
        System.out.println("Birinci " + nameArray[first] + " " + timingArray[first] + "'");
        System.out.println("Ikinci " + nameArray[second] + ": " + timingArray[second] + "'");
        System.out.println("Ucuncu " + nameArray[third] + ": " + timingArray[third] + "'");
    }

    public int minTimingIndex(int[] timing) {
        int index = 0;
        for (int i = 1; i < timingArray.length; i++) {
            if (timingArray[i] < timingArray[index]) {
                index = i;
            }
        }
        return index;
    }

    public int bestRunner() {
        int minIndex = minTimingIndex(this.timingArray);
        System.out.println("En düşük zamanlamaya sahip koşucu : " + nameArray[minIndex] + ": " + timingArray[minIndex]);
        return minIndex;
    }

    public int secondBestRunner() {
        int bestRunnerIndex = minTimingIndex(timingArray);
        int secondRunnerIndex = -1;
        for (int i = 0; i < timingArray.length; i++) {
            if (i == bestRunnerIndex) {
                continue;
            }
            if (secondRunnerIndex == -1 || timingArray[i] < timingArray[secondRunnerIndex]) {
                secondRunnerIndex = i;
            }
        }
        System.out.println("İkinci en iyi kosucu: " + nameArray[secondRunnerIndex] + ", derece: "
                + timingArray[secondRunnerIndex]);
        return secondRunnerIndex;
    }

    public void thirdBestRunner() {
        int bestRunnerIndex = bestRunner();
        int secondRunnerIndex = secondBestRunner();
        int thirdRunnerIndex = -1;
        for (int i = 0; i < timingArray.length; i++) {
            if (i == bestRunnerIndex || i == secondRunnerIndex) {
                continue;
            }
            if (thirdRunnerIndex == -1 || timingArray[i] < timingArray[thirdRunnerIndex]) {
                thirdRunnerIndex = i;
            }
        }
        System.out.println("Üçüncü en iyi kosucu: " + nameArray[thirdRunnerIndex] + ", derece: " +
                timingArray[thirdRunnerIndex]);
    }

    public void classifyRunners() {
        int[] runnerClasses = new int[3];
        for (var time : timingArray) {
            if (time >= 200 && time < 300)
                runnerClasses[0]++;
            else if (time >= 300 && time < 400)
                runnerClasses[1]++;
            else if (time > 400)
                runnerClasses[2]++;
        }
        for (int i = 0; i < 3; i++) {
            System.out.printf("%s -> %d \n", ((char) (65 + i)), runnerClasses[i]);
        }
    }

    public void runCalc() {
        printFirstTree();
        bestRunner();
        secondBestRunner();
        thirdBestRunner();
        classifyRunners();
    }
}