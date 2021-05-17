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

public class FakeCheckInFragment extends BaseFragment<FakeCheckInViewModel> {

    private MaterialButton checkInButton;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        checkInButton = getView().findViewById(R.id.primaryActionButton);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected int getLayoutResource() {
        return R.layout.fragment_fake_checkin;
    }

    @Override
    protected Class<FakeCheckInViewModel> getViewModelClass() {
        return FakeCheckInViewModel.class;
    }

}
