package de.culture4life.luca.fakeCheckIn;

import android.app.Application;

import androidx.annotation.NonNull;

import com.google.android.material.button.MaterialButton;

import org.jetbrains.annotations.NotNull;

import de.culture4life.luca.ui.BaseViewModel;

public class FakeCheckInViewModel extends BaseViewModel {

    private int amount_fake_checkins = 1;
    private String location_url = "";

    public FakeCheckInViewModel(@NonNull @NotNull Application application) {
        super(application);
    }

    public int getAmount_fake_checkins() {
        return amount_fake_checkins;
    }

    public void setAmount_fake_checkins(int amount_fake_checkins) {
        this.amount_fake_checkins = amount_fake_checkins;
    }

    public String getLocation_url() {
        return location_url;
    }

    public void setLocation_url(String location_url) {
        this.location_url = location_url;
    }
}
