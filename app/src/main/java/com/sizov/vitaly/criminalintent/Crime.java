package com.sizov.vitaly.criminalintent;

import java.util.UUID;

public class Crime {

    private UUID mId;
    private String mTitle;

    public Crime() {
        // Генерирование уникального индификатора
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
