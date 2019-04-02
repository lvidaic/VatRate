package com.barclays.client;

import com.barclays.client.model.JsonVat;

public interface VatRepository<T extends JsonVat> {

    public T fetchJsonVat();

}
