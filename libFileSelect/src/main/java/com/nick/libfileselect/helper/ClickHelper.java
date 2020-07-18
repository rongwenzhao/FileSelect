package com.nick.libfileselect.helper;


import com.nick.libfileselect.adapter.FileSelectorAdapter;
import com.nick.libfileselect.bean.FileItem;
import com.nick.libfileselect.util.FileSelectorUtils;
import com.nick.libfileselect.util.FileUtils;
import com.nick.libfileselect.widget.FileSelectorLayout;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 */
public class ClickHelper implements FileSelectorAdapter.OnFileItemClickListener,
        FileSelectorLayout.OnButtonClickListener {
    private FileSelectorLayout selectorLayout;
    private FileSelector.OnFileSelectListener onFileSelectListener;

    public ClickHelper(FileSelectorLayout selectorLayout, FileSelector.OnFileSelectListener onFileSelectListener) {
        this.selectorLayout = selectorLayout;
        this.onFileSelectListener = onFileSelectListener;
    }


    @Override
    public void onFolderClick(File file) {
        if (file == null) {
            return;
        }
        selectorLayout.refreshUI(file.getAbsolutePath(), FileSelectorUtils.parseToFileItemList(file.listFiles(selectorLayout.getFileFilter())));
    }

    @Override
    public void onFileSelected(File file) {
        if (onFileSelectListener == null || file == null) {
            return;
        }
        ArrayList<String> list = new ArrayList<>();
        list.add(file.getAbsolutePath());
        onFileSelectListener.onSelected(list);
    }

    @Override
    public void onBackLevelClick(String currentFolder) {
        if (FileSelectorUtils.isEmpty(currentFolder)) {
            return;
        }
        File currentFile = new File(currentFolder);
        if (!currentFile.exists()) {
            return;
        }
        File fileRoot = FileUtils.getRootFile();
        if (fileRoot == null || fileRoot.getAbsolutePath().equals(currentFile.getAbsolutePath())) {
            //已经是根目录
            return;
        }
        onFolderClick(currentFile.getParentFile());
    }

    @Override
    public void onSubmitClick(List<FileItem> list) {
        if (onFileSelectListener == null || FileSelectorUtils.isEmpty(list)) {
            return;
        }
        onFileSelectListener.onSelected(FileSelectorUtils.getSelectedFileList(list));
    }
}
