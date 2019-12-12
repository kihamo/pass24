package ru.tenant.pass24.Login;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.Helpers.Constants;
import ru.tenant.pass24.Helpers.Retrofit.ApiService;
import ru.tenant.pass24.Login.apiModels.LoginRequestBody;
import ru.tenant.pass24.Login.apiModels.LoginResponse;

public class LoginModel {
    public LoginPresenter loginPresenter;

    public void login(String phone, String password) {
        ApiService.getInstance().getAuthApi().getLogin(new LoginRequestBody(phone, password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginResponse loginResponse) {
                        if (loginResponse.getError() != null)
                            loginPresenter.onError(loginResponse.getError().getCode(), loginResponse.getError().getMessage());
                        else if (loginResponse.getBody() != null) {
                            Constants.authToken = loginResponse.getBody();
                            loginPresenter.onLoggedIn();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        //todo add dialog
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
