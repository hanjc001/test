package com.example.a1027.week151105.calc;

/**
 * Created by 1027 on 2016-11-05.
 */

public class CalcServiceImpl implements CalcService {
    @Override
    public int plus(CalcDTO dto) {
        return dto.getFirst() + dto.getSecond();
    }

    @Override
    public int minus(CalcDTO dto) {
        return dto.getFirst() - dto.getSecond();
    }

    @Override
    public int mul(CalcDTO dto) {
        return dto.getFirst() * dto.getSecond();
    }

    @Override
    public int div(CalcDTO dto) {
        return dto.getFirst() / dto.getSecond();
    }

    @Override
    public int mod(CalcDTO dto) {
        return dto.getFirst() % dto.getSecond();
    }
}
