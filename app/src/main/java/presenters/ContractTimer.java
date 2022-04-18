package presenters;

public interface ContractTimer {
    interface TimerView {
        public void changeState();
    }

    interface TimerPresenter {
        public int getTime();
        public int getMinutes();
        public int getHours();
        public int getSeconds();
        public void init();
    }
}
