package de.culture4life.luca.fakeCheckIn;

import android.app.Application;

import androidx.annotation.NonNull;

import com.google.android.material.button.MaterialButton;

import org.jetbrains.annotations.NotNull;

import java.security.SecureRandom;
import java.util.UUID;

import de.culture4life.luca.network.NetworkManager;
import de.culture4life.luca.network.pojo.CheckInRequestData;
import de.culture4life.luca.ui.BaseViewModel;
import de.culture4life.luca.ui.qrcode.QrCodeViewModel;
import io.reactivex.rxjava3.core.Single;
import timber.log.Timber;

public class FakeCheckInViewModel extends BaseViewModel {

    private int amount_fake_checkins = 1;
    private String location_url = "";

    private final NetworkManager networkManager;

    public FakeCheckInViewModel(@NonNull Application application) {
        super(application);
        networkManager = this.application.getNetworkManager();
    }


    public void onFakeRegistrationRequested(int number, String url) {

        for (int i = 0; i < number; i++) {
            checkIn(url);
        }
    }

    private void checkIn(String url) {
//        String url = "https://192.168.178.28/webapp/429c807a-afce-4804-9559-f73d9ca2368d#e30";

        CheckInRequestData data = new CheckInRequestData();
        data.setDeviceType(0);

        data.setUnixTimestamp(System.currentTimeMillis() / 1000L);

        Single<UUID> scannerId = QrCodeViewModel.getScannerIdFromUrl(url);
        data.setScannerId(scannerId.blockingGet().toString());

        data.setTraceId(randomString(24));

        data.setScannerEphemeralPublicKey(randomString(88));

        data.setIv(randomString(24));

        data.setReEncryptedQrCodeData(randomString(24));

        data.setMac(randomString(44));

        modelDisposable.add(Single.just(data)
                .flatMapCompletable(checkInData -> networkManager.getLucaEndpointsV3().blockingGet().checkIn(checkInData))
                .subscribe(() -> Timber.i("User registered")));
    }

    String randomString(int len){
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
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
