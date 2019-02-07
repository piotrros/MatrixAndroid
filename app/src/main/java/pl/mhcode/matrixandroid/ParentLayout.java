package pl.mhcode.matrixandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ParentLayout extends RelativeLayout {

    public Matrix matrix = new Matrix();

    public ParentLayout(Context context) {
        super(context);
    }

    public ParentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ParentLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.concat(matrix);
        super.onDraw(canvas);
    }
}
