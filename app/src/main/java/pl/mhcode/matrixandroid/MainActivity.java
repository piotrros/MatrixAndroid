package pl.mhcode.matrixandroid;

import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ParentLayout parentLayout;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parentLayout = findViewById(R.id.parentLayout);
        imageView = findViewById(R.id.imageView);
        parentLayout.post(new Runnable() {

            @Override
            public void run() {
                float midX = parentLayout.getWidth() / 2.0f;
                float midY = parentLayout.getHeight() / 2.0f;

                parentLayout.matrix.postScale(0.5f, 0.5f, midX, midY);
                parentLayout.matrix.postRotate(180 / 4, midX, midY);

                float[] values = new float[9];
                parentLayout.matrix.getValues(values);

                Log.e("MainActivity", "tx: " + values[Matrix.MTRANS_X] + ", ty: " + values[Matrix.MTRANS_Y]);

                values[Matrix.MTRANS_X] /= parentLayout.getWidth();
                values[Matrix.MTRANS_Y] /= parentLayout.getHeight();

                String log = "Output: ";
                for(int i = 0; i < 6; i++) {
                    log += values[i];
                    if(i + 1 < 6) log += ", ";
                }

                Log.e("MainActivity", "midX: " + midX + ", midY: " + midY);
                Log.e("MainActivity", log);

                //Matrix:
                //{Scale X, Skew X, Transform X
                //Skew Y, Scale Y, Transform Y
                //Perspective 0, Perspective 1, Perspective 2}
            }

        });
    }
}
