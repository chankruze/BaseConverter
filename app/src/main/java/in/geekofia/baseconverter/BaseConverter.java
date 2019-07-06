package in.geekofia.baseconverter;

import static in.geekofia.baseconverter.ConverterFunctions.FN_CODES.*;
import static in.geekofia.baseconverter.ConverterFunctions.FN_MATH.*;

public class BaseConverter {

    private String BaseFrom, BaseTo, numberInput;

    public BaseConverter(String BaseFrom, String BaseTo, String number) {
        this.BaseFrom = BaseFrom;
        this.BaseTo = BaseTo;
        this.numberInput = number;
    }

    public String convert() {
        String convertedNumber = "";
        int CASE_VALUE = Integer.parseInt(this.BaseFrom + this.BaseTo);
        switch (CASE_VALUE) {
            /***************
             * From Binary
             **************/
            case BIN2OCT:
                convertedNumber = "Not Implemented Yet";
                break;
            case BIN2DEC:
                convertedNumber = Binary2Decimal(Integer.parseInt(this.numberInput));
                break;
            case BIN2HEX:
                convertedNumber = "Not Implemented Yet";
                break;

            /*************
             * From Octal
             *************/
            case OCT2BIN:
                convertedNumber = "Not Implemented Yet";
                break;
            case OCT2DEC:
                convertedNumber = Octal2Decimal(Integer.parseInt(this.numberInput));
                break;
            case OCT2HEX:
                convertedNumber = "Not Implemented Yet";
                break;

            /***************
             * From Decimal
             ***************/
            case DEC2BIN:
                convertedNumber = Decimal2Binary(Integer.parseInt(this.numberInput));
                break;
            case DEC2OCT:
                convertedNumber = Decimal2Octal(Integer.parseInt(this.numberInput));
                break;
            case DEC2HEX:
                convertedNumber = Decimal2Hex(Integer.parseInt(this.numberInput));
                break;

            /*******************
             * From Hexadecimal
             *******************/
            case HEX2BIN:
                convertedNumber = "Not Implemented Yet";
                break;
            case HEX2OCT:
                convertedNumber = "Not Implemented Yet";
                break;
            case HEX2DEC:
                convertedNumber = Hex2Decimal(this.numberInput);
                break;

            /***********************************************
             * Default (HEX2HEX, BIB2BIN, DEC2DEC, OCT2OCT)
             ***********************************************/
            default:
                convertedNumber = this.numberInput;
                break;
        }
        return convertedNumber;
    }
}
