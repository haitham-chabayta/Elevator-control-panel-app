package adu.ac.ae.elevatorcontrolpanelapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {

    SurfaceView surfaceView;
    CameraSource cameraSource;
    BarcodeDetector barcodeDetector;
    TextView textView;
    Hashtable<String, Intent> qrCodesTable = new Hashtable<String, Intent>();
    Intent elevatorOneActivity;
    Intent elevatorTwoActivity;
    Intent elevatorThreeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elevatorOneActivity = new Intent(this, ElevatorNumberOneActivity.class);
        elevatorTwoActivity = new Intent(this, ElevatorNumberTwoActivity.class);
        elevatorThreeActivity = new Intent(this, ElevatorNumberThreeActivity.class);

        qrCodesTable.put("2266", elevatorOneActivity);
        qrCodesTable.put("5544", elevatorTwoActivity);
        qrCodesTable.put("4433", elevatorThreeActivity);

        surfaceView = (SurfaceView)findViewById(R.id.cameraPreview);
        textView = (TextView)findViewById(R.id.scannerTextView);

            barcodeDetector = new BarcodeDetector.Builder(this)
                    .setBarcodeFormats(Barcode.QR_CODE).build();

            cameraSource = new CameraSource.Builder(this, barcodeDetector)
                    .setRequestedPreviewSize(640,480).build();

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                    requestPermission();
                }

                try {
                    Thread.sleep(2000);
                    cameraSource.start(holder);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                    cameraSource.stop();
            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> qrCodes = detections.getDetectedItems();

                if(qrCodes.size()!=0)
                {
                            Vibrator vibrator = (Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                            String qrCodeString = qrCodes.valueAt(0).displayValue;
                            if(qrCodesTable.get(qrCodeString)==null){
                                vibrator.vibrate(100);
                                textView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast toast = Toast.makeText(getApplicationContext(), "Invalid QR code scanned", Toast.LENGTH_LONG);
                                        toast.show();
                                    }
                                });
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            else {
                                vibrator.vibrate(100);
                                startActivity(qrCodesTable.get(qrCodeString));
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }

                }

            }
        });

    }

    public void requestPermission(){

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CAMERA}, 1);
    }
}
