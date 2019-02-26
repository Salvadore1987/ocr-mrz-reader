package uz.asbt.ocr.mrz.reader;

public class MRZReaderException extends Exception {

    private Integer code;

    public MRZReaderException(Integer code) {
        this.code = code;
    }

    public MRZReaderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
