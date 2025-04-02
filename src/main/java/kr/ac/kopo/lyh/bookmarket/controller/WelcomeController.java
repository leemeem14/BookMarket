package kr.ac.kopo.lyh.bookmarket.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WelcomeController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcomeMethod() {
        String welcomeHtml = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>BookMarket</title>\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<main>\n" +
                "    <div class=\"container py-4\">\n" +
                "        <header class=\"pb-3 mb-4 border-bottom\">\n" +
                "            <a href=\"/\" class=\"d-flex align-items-center text-body-emphasis text-decoration-none\">\n" +
                "                <svg width=\"32px\" height=\"32px\" viewBox=\"0 -0.5 20 20\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n" +
                "\n" +
                "                    <title>book [#1207]</title>\n" +
                "                    <desc>Created with Sketch.</desc>\n" +
                "                    <defs>\n" +
                "\n" +
                "                    </defs>\n" +
                "                    <g id=\"Page-1\" stroke=\"none\" stroke-width=\"1\" fill=\"none\" fill-rule=\"evenodd\">\n" +
                "                        <g id=\"Dribbble-Light-Preview\" transform=\"translate(-260.000000, -2759.000000)\" fill=\"#000000\">\n" +
                "                            <g id=\"icons\" transform=\"translate(56.000000, 160.000000)\">\n" +
                "                                <path d=\"M222,2612.40709 C222,2612.84565 221.729,2613.23594 221.324,2613.3787 L215,2615.60539 L215,2603.71501 L215,2603.53322 L220.676,2601.53454 C221.325,2601.3055 222,2601.80055 222,2602.50615 L222,2612.40709 Z M213,2603.71501 L213,2615.60539 L206.676,2613.3787 C206.271,2613.23594 206,2612.84565 206,2612.40709 L206,2602.50615 C206,2601.80055 206.675,2601.3055 207.324,2601.53454 L213,2603.53322 L213,2603.71501 Z M221.337,2599.11785 L214.331,2601.64444 C214.117,2601.72147 213.883,2601.72147 213.669,2601.64444 L206.663,2599.11785 C205.362,2598.64847 204,2599.6396 204,2601.05592 L204,2613.11577 C204,2613.997 204.547,2614.78065 205.36,2615.06207 L213.68,2617.94608 C213.888,2618.01797 214.112,2618.01797 214.32,2617.94608 L222.64,2615.06207 C223.453,2614.78065 224,2613.997 224,2613.11577 L224,2601.05592 C224,2599.6396 222.638,2598.64847 221.337,2599.11785 L221.337,2599.11785 Z\" id=\"book-[#1207]\">\n" +
                "                                </path>\n" +
                "                            </g>\n" +
                "                        </g>\n" +
                "                    </g>\n" +
                "                </svg>\n" +
                "                <span class=\"fs-4\">&nbsp;&nbsp;BookMarket</span>\n" +
                "            </a>\n" +
                "        </header>\n" +
                "        <div class=\"p-5 mb-4 bg-body-tertiary rounded-3\">\n" +
                "            <div class=\"container-fluid py-5\">\n" +
                "                <h1 class=\"display-5 fw-bold\">도서 쇼핑몰에 오신걸 환영합니다</h1>\n" +
                "                <p class=\"col-md-8 fs-4\">BookMarket</p>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"row align-items-md-stretch text-center\">\n" +
                "            <div class=\"col-md-12\">\n" +
                "                <div class=\"h-100 p-5\">\n" +
                "                    <h2>Welcome to Web Market</h2>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <footer class=\"pt-3 mt-4 text-body-secondary border-top\">\n" +
                "            <span class=\"text-body-secondary\">&copy;2025 BookMarket</span>\n" +
                "        </footer>\n" +
                "    </div>\n" +
                "</main>\n" +
                "\n" +
//                "<h1>Welcome to the BookMarket</h1>\n" +
//                "<h3>Welcome to Book Shopping Mall</h3>\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        return welcomeHtml;
    }
}
