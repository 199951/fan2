package com.fan.service;

public interface TradeService {
    void transfer(String bankCode, String otherCode, Double money);
}
