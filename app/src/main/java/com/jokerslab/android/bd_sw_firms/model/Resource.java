package com.jokerslab.android.bd_sw_firms.model;

import android.support.annotation.Nullable;

import static com.jokerslab.android.bd_sw_firms.model.Status.*;

/**
 * Created by sayem on 9/27/2017.
 */

public class Resource<T> {

    public final int status;

    @Nullable
    public final String message;

    @Nullable
    public final T data;

    public Resource(int status, T data, String message) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> Resource<T> success(@Nullable T data) {
        return new Resource<>(SUCCESS, data, null);
    }


    public static <T> Resource<T> error(String message, @Nullable T data) {
        return new Resource<>(ERROR, data, message);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(LOADING, data, null);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Resource<?> resource = (Resource<?>) obj;
        if (status != resource.status) return false;
        if (message != null ? !message.equals(resource.message) : resource.message != null) return false;
        return data != null ? data.equals(resource.data) : resource.data == null;
    }

    @Override
    public int hashCode() {
        int result = status;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
