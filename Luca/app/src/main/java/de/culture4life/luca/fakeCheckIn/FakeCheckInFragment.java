package de.culture4life.luca.fakeCheckIn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

import org.jetbrains.annotations.NotNull;

import de.culture4life.luca.R;
import de.culture4life.luca.ui.BaseFragment;
import de.culture4life.luca.ui.registration.RegistrationViewModel;

public class FakeCheckInFragment extends Fragment {

    private int amount_fake_checkins = 1;
    private String location_url = "";
    private MaterialButton checkInButton;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        checkInButton = getView().findViewById(R.id.primaryActionButton);
        return super.onCreateView(inflater, container, savedInstanceState);
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

    protected int getLayoutResource() {
        return R.layout.fragment_fake_checkin;
    }

}
