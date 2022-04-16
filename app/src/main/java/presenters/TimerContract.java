package presenters;

public interface TimerContract {
    interface TimerView {
        void showError(String error);
    }

    interface TimerPresenter {
        public void setMessage(String message);
        public void setName(String name);
        public void setInterval(int interval);
        public void setTimeToActive(int timeToActive);
        public void getListFieldsSelect(String field);
        public void setView(TimerView view);
    }
}