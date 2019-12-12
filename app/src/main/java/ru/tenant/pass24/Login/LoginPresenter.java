package ru.tenant.pass24.Login;

import androidx.fragment.app.FragmentManager;

import ru.tenant.pass24.MainScreen;
import ru.tenant.pass24.R;

public class LoginPresenter {
    private final LoginModel model;
    private LoginFragment view;
    private FragmentManager fragmentManager;

    public LoginPresenter(LoginModel model) {
        this.model = model;
        if (model != null)
            model.loginPresenter = this;
    }

    public void attachView(LoginFragment loginFragment) {
        view = loginFragment;
        fragmentManager = view.getActivity().getSupportFragmentManager();
    }

    public void detachView() {
        view = null;
    }

    public void login(String phone, String password) {
        model.login(phone, password);
    }

    public void onError(String errorTitle, String errorMessage) {
        view.showError(errorTitle, errorMessage);
    }

    public void onLoggedIn() {
        fragmentManager.beginTransaction().add(R.id.flMainContainer, new MainScreen()).commit();
    }

    public void toRegistry() {
        fragmentManager.beginTransaction().add(R.id.flMainContainer, new MainScreen()).commit();
    }

    public void toForgotPass() {
        fragmentManager.beginTransaction().add(R.id.flMainContainer, new MainScreen()).commit();
    }
}