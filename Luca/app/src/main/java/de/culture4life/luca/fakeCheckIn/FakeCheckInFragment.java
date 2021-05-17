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
import io.reactivex.rxjava3.core.Completable;
import timber.log.Timber;

public class FakeCheckInFragment extends BaseFragment<FakeCheckInViewModel> {

    private MaterialButton checkInButton;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected Completable initializeViews() {
        return super.initializeViews()
                .andThen(Completable.fromAction(() -> {
                    initializeSharedViews();
                }));
    }

    private void initializeSharedViews() {
        checkInButton = getView().findViewById(R.id.primaryActionButton);

        checkInButton.setOnClickListener(v -> viewDisposable.add(Completable.fromAction(
                () -> {
                    Timber.i("Fake Check In clicked");
                    viewModel.onFakeRegistrationRequested();
                })
                .subscribe()));
    }

    protected int getLayoutResource() {
        return R.layout.fragment_fake_checkin;
    }

    @Override
    protected Class<FakeCheckInViewModel> getViewModelClass() {
        return FakeCheckInViewModel.class;
    }

}
