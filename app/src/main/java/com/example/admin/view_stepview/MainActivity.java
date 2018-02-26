package com.example.admin.view_stepview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

/**
 * 自定义View中的StepView
 */
public class MainActivity extends AppCompatActivity {
    private StepView step1, step2, step3, step4, step5, step6;
    private CheckBox click1, click2, click3, click4, click5, click6;
    private CheckBox text1, text2, text3, text4, text5, text6;
    private String[] texts = {"确认身份信息", "确认入住信息", "选择房型", "支付押金", "完成入住"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        step1 = findViewById(R.id.step1);
        step2 = findViewById(R.id.step2);
        step3 = findViewById(R.id.step3);
        step4 = findViewById(R.id.step4);
        step5 = findViewById(R.id.step5);
        step6 = findViewById(R.id.step6);

        click1 = findViewById(R.id.click1);
        click2 = findViewById(R.id.click2);
        click3 = findViewById(R.id.click3);
        click4 = findViewById(R.id.click4);
        click5 = findViewById(R.id.click5);
        click6 = findViewById(R.id.click6);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);
        text6 = findViewById(R.id.text6);

        step1.setDescription(texts);
        step2.setDescription(texts);
        step3.setDescription(texts);
        step4.setDescription(texts);
        step5.setDescription(texts);
        step6.setDescription(texts);

        step1.setStep(StepView.Step.ONE);
        step2.setStep(StepView.Step.TWO);
        step3.setStep(StepView.Step.THREE);
        step4.setStep(StepView.Step.FOUR);
        step5.setStep(StepView.Step.FIVE);
        step6.setStep(StepView.Step.FOUR);

        clickableChaged(click1, step1);
        clickableChaged(click2, step2);
        clickableChaged(click3, step3);
        clickableChaged(click4, step4);
        clickableChaged(click5, step5);
        clickableChaged(click6, step6);

        textLocationChanged(text1, step1);
        textLocationChanged(text2, step2);
        textLocationChanged(text3, step3);
        textLocationChanged(text4, step4);
        textLocationChanged(text5, step5);
        textLocationChanged(text6, step6);
    }

    private void clickableChaged(CheckBox check, final StepView step) {
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                step.setClickable(isChecked);
            }
        });
    }

    private void textLocationChanged(CheckBox check, final StepView step) {
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                step.setTextBelowLine(!isChecked);
            }
        });
    }
}
