package com.nick.libfileselect.ui;

import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nick.libfileselect.R;
import com.nick.libfileselect.helper.FileSelector;
import com.nick.libfileselect.widget.FileSelectorLayout;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FilePickerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FilePickerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FileSelectorLayout fileSelectorLayout;

    public FilePickerFragment() {
        // Required empty public constructor
    }

    public static FilePickerFragment newInstance(String param1, String param2) {
        FilePickerFragment fragment = new FilePickerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_file_picker, container, false);
        initViewAndData(root);
        return root;
    }

    private void initViewAndData(View root) {
        fileSelectorLayout = root.findViewById(R.id.file_select_layout);
        FileSelector.with(fileSelectorLayout).listen(new FileSelector.OnFileSelectListener() {
            @Override
            public void onSelected(ArrayList<String> list) {
                Toast.makeText(getContext(), "选中文件个数： size = " + (list == null ? 0 : list.size()), Toast.LENGTH_SHORT).show();
            }
        })
                .setDefaultFile(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS))
                .setup();

    }
}