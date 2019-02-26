package uz.asbt.ocr.mrz.reader;

import NSOCR.*;

public class Scanner implements AutoCloseable {

    private HCFG CfgObj;
    private HIMG ImgObj;
    private HOCR OcrObj;
    private HSVR SvrObj;
    private String fileIn;
    private String fileOut;

    public Scanner(String fileIn, String fileOut) {
        CfgObj = new HCFG();
        ImgObj = new HIMG();
        OcrObj = new HOCR();
        SvrObj = new HSVR();
        this.fileIn = fileIn;
        this.fileOut = fileOut;
    }

    public void scan() throws MRZReaderException {
        Engine.Engine_SetLicenseKey("AB2A4DD5FF2A");
        boolean isDllLoaded = Engine.IsDllLoaded();
        System.out.println(isDllLoaded);
        if (isDllLoaded) {
            int res = 0;
            res = Engine.Engine_InitializeAdvanced(CfgObj, OcrObj, ImgObj);
            if (res > NSOCR.Error.ERROR_FIRST) {
                throw new MRZReaderException(98000, "Can not initialize engine");
            }

            res = Engine.Cfg_SetOption(CfgObj, Constant.BT_DEFAULT, "Zoning/OneZone", "9");
            if (res > NSOCR.Error.ERROR_FIRST) {
                throw new MRZReaderException(98001, "Can not set the options");
            }

            res = Engine.Img_LoadFile(ImgObj, fileIn);
            if (res > NSOCR.Error.ERROR_FIRST) {
                throw new MRZReaderException(98002, "Can not load an image");
            }

            Engine.Svr_Create(CfgObj,  Constant.SVR_FORMAT_XML, SvrObj);
            Engine.Svr_NewDocument(SvrObj);
            res = Engine.Img_OCR(ImgObj, Constant.OCRSTEP_FIRST, Constant.OCRSTEP_LAST, Constant.OCRFLAG_NONE);
            if (res > NSOCR.Error.ERROR_FIRST) {
                throw new MRZReaderException(98003, "Can not parse an image");
            }

            res = Engine.Svr_AddPage(SvrObj, ImgObj, Constant.FMT_EXACTCOPY);
            if (res > NSOCR.Error.ERROR_FIRST) {
                throw new MRZReaderException(98004, "Can not add page");
            }

            res = Engine.Svr_SaveToFile(SvrObj, fileOut);
            if (res > NSOCR.Error.ERROR_FIRST) {
                throw new MRZReaderException(98005, "Can not save document");
            }
            Engine.Engine_Uninitialize();
        }
    }

    public MRZData getData() throws Exception {
        return ReadXML.readXML(fileOut);
    }

    public void close() {
        CfgObj = null;
        ImgObj = null;
        OcrObj = null;
        SvrObj = null;
    }
}
