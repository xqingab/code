public class RequestHelper {


    /**
     * 获取请求参数
     */
    public static Param createParam(HttpServletRequest request) throws IOException {
        Map<String, Object> paramMap = new HashMap<>();
        Enumeration<String> paramNames = request.getParameterNames();
        //没有参数
        if (!paramNames.hasMoreElements()) {
            return null;
        }

        //get和post参数都能获取到
        while (paramNames.hasMoreElements()) {
            String fieldName = paramNames.nextElement();
            String fieldValue = request.getParameter(fieldName);
            paramMap.put(fieldName, fieldValue);
        }

        return new Param(paramMap);
    }
}
