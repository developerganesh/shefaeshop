package com.linkysoft.shefaeshop.domain.interactors;

import com.linkysoft.shefaeshop.Models.SliderImage;

import java.util.List;

public interface SliderInteractor {

    interface CallBack {

        void onSliderDownloaded(List<SliderImage> sliderImages);

        void onSliderDownloadError();
    }
}
