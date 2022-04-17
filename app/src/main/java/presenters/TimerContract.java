package presenters;

import com.google.android.material.textfield.TextInputLayout;

public interface TimerContract {
    interface TimerView {
        void showError(String error);
        void showSucesss() throws Exception;
    }

    interface TimerPresenter {
        public void setMessage(String message);
        public void setName(String name);
        public void setInterval(String interval);
        public void setTimeToActive(String timeToActive);
        public void getListFieldsSelect(String field);
        public void setView(TimerView view);
        public boolean verifyFields();
    }
}