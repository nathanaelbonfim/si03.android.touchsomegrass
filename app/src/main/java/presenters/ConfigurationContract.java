package presenters;

import com.google.android.material.textfield.TextInputLayout;

public interface ConfigurationContract {
    interface ConfigurationView {
        void showError(String error);
        void showSucesss() throws Exception;
    }

    interface ConfigurationPresenter {
        public void setMessage(String message);
        public void setName(String name);
        public void setInterval(String interval);
        public void setTimeToActive(String timeToActive);
        public void getListFieldsSelect(String field);
        public void setView(ConfigurationView view);
        public boolean verifyFields();
    }
}