package com.linkysoft.shefaeshop.domain.interactors;

import com.linkysoft.shefaeshop.Models.PolicyContent;

public interface PolicyInteractor {
    interface CallBack {

        void onPolicyLoaded(PolicyContent policyContent);

        void onPolicyLoadError();
    }
}
