package com.nick.libfileselect.provide.order;


import com.nick.libfileselect.bean.FileItem;
import com.nick.libfileselect.util.FileSelectorUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 */
public class FileOrderProvide {

    public void order(List<FileItem> list) {
        if (FileSelectorUtils.isEmpty(list)) {
            return;
        }
        ArrayList<FileItem> fileList = new ArrayList<>();
        ArrayList<FileItem> folderList = new ArrayList<>();
        int size = list.size();
        FileItem fileItem;
        for (int i = 0; i < size; i++) {
            fileItem = list.get(i);
            if (fileItem == null || fileItem.file == null) {
                continue;
            }
            if (fileItem.file.isFile()) {
                fileList.add(fileItem);
            } else {
                folderList.add(fileItem);
            }
        }
        Collections.sort(fileList);
        Collections.sort(folderList);
        list.clear();
        list.addAll(folderList);
        list.addAll(fileList);
    }

}
