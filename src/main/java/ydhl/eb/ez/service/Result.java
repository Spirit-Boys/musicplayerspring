package ydhl.eb.ez.service;

public class Result<T> {
	public static final int OK = 1;
	public static final int ERROR = 0;
	public static final int DUPLICATED = -1;
	
	private int status;
    private String message;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
    public Result<T> ok() {
    	Result<T> result = new Result<>();
    	result.setStatus(OK);
    	result.setMessage("操作成功");
    	return result;
    }
    
    public Result<T> error() {
    	Result<T> result = new Result<>();
    	result.setStatus(ERROR);
    	result.setMessage("操作失败");
    	return result;
    }
}