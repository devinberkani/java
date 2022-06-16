class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        // implement me
        this.minutes += 1;
        if (this.minutes > 59) {
            this.minutes = 0;
            this.hours += 1;
            if (this.hours > 12) {
                this.hours = 1;
            }
        }
    }
}