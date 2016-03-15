/*
 * Copyright (c) 2013,2014 Scott Oaks. All rights reserved.
 */

package net.sdo.stockimpl;

import net.sdo.stock.StockOptionPrice;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="StockOptionPrice")
public class StockOptionPriceLazyLazyImpl implements StockOptionPrice {
    @EmbeddedId
    private StockOptionPK id;

    @Column(precision = 30, scale = 2)
    private BigDecimal price;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns(
        {@JoinColumn(name="symbol", referencedColumnName="SYMBOL",
                     insertable=false, updatable=false),
        @JoinColumn(name="priceDate", referencedColumnName="priceDate",
                    insertable=false, updatable=false)
        })
    private StockPriceLazyLazyImpl stock;

    @Override
    public String getSymbol() {
        return id.getSymbol();
    }

    @Override
    public Date getDate() {
        return id.getDate();
    }

    @Override
    public int getExpirationPeriod() {
        return id.getExpirationPeriod();
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    public void setId(StockOptionPK id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
