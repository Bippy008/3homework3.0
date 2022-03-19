package kg.geektech.a3homework30;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FourthFragment extends Fragment {

    Button sendBtn;
    EditText textEt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sendBtn = view.findViewById(R.id.send_btn4);
        textEt = view.findViewById(R.id.text_et4);

        getData();
        sendData();
    }

    private void getData() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            String text = bundle.getString("text3");
            textEt.setText(text);
        }
    }

    private void sendData() {
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textEt.getText().toString().isEmpty()) {
                    textEt.setError("Это поле не должно быть пустым");
                    return;
                }
                Bundle bundle = new Bundle();
                String text4 = textEt.getText().toString();
                bundle.putString("text4", text4);
                Fragment fifthFragment = new FifthFragment();
                fifthFragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fifthFragment).commit();
            }
        });
    }
}