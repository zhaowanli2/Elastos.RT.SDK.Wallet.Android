
package com.elastos.spvcore;

/**
 * ISubWallet
 */
public class ISubWallet {
    private long mSubProxy;

    public String GetChainId() throws WalletException {
        return nativeGetChainId(mSubProxy);
    }

	public String GetBasicInfo() throws WalletException {
		return nativeGetBasicInfo(mSubProxy);
	}

    public String GetBalanceInfo() throws WalletException {
        return nativeGetBalanceInfo(mSubProxy);
    }

    public long GetBalance() throws WalletException {
        return nativeGetBalance(mSubProxy);
    }

    public String CreateAddress() throws WalletException {
        return nativeCreateAddress(mSubProxy);
    }

    public String GetAllAddress(int start, int count) throws WalletException {
        return nativeGetAllAddress(mSubProxy, start, count);
    }

    public long GetBalanceWithAddress(String address) throws WalletException {
        return nativeGetBalanceWithAddress(mSubProxy, address);
    }

    public void AddCallback(ISubWalletCallback subCallback) throws WalletException {
        nativeAddCallback(mSubProxy, subCallback);
    }

    public void RemoveCallback() throws WalletException {
        nativeRemoveCallback(mSubProxy);
    }

    public String CreateTransaction(String fromAddress, String toAddress, long amount, String memo, String remark) throws WalletException {
        return nativeCreateTransaction(mSubProxy, fromAddress, toAddress, amount, memo, remark);
    }

    public String CreateMultiSignTransaction(String fromAddress, String toAddress, long amount, String memo) throws WalletException {
        return nativeCreateMultiSignTransaction(mSubProxy, fromAddress, toAddress, amount, memo);
    }

    public long CalculateTransactionFee(String rawTransaction, long feePerKb) throws WalletException {
        return nativeCalculateTransactionFee(mSubProxy, rawTransaction, feePerKb);
    }

	public String UpdateTransactionFee(String rawTransaction, long fee) throws WalletException {
		return nativeUpdateTransactionFee(mSubProxy, rawTransaction, fee);
	}

	public String SignTransaction(String rawTransaction, String payPassword) throws WalletException {
		return nativeSignTransaction(mSubProxy, rawTransaction, payPassword);
	}

	public String GetTransactionSignedSigners(String rawTransaction) throws WalletException {
		return nativeGetTransactionSignedSigners(mSubProxy, rawTransaction);
	}

	public String PublishTransaction(String rawTransaction) throws WalletException {
		return nativePublishTransaction(mSubProxy, rawTransaction);
	}

    public String GetAllTransaction(int start, int count, String addressOrTxId) throws WalletException {
        return nativeGetAllTransaction(mSubProxy, start, count, addressOrTxId);
    }

    public String Sign(String message, String payPassword) throws WalletException {
        return nativeSign(mSubProxy, message, payPassword);
    }

    public String CheckSign(String publicKey, String message, String signature) throws WalletException {
        return nativeCheckSign(mSubProxy, publicKey, message, signature);
    }

	public String GetPublicKey() throws WalletException {
		return nativeGetPublicKey(mSubProxy);
	}

    public ISubWallet(long proxy) {
        mSubProxy = proxy;
    }

    protected long getProxy() {
        return mSubProxy;
    }

    private native String nativeGetChainId(long subProxy);
    private native String nativeGetBasicInfo(long subProxy);
    private native String nativeGetBalanceInfo(long subProxy);
    private native long nativeGetBalance(long subProxy);
    private native String nativeCreateAddress(long subProxy);
    private native String nativeGetAllAddress(long subProxy, int start,int count);
    private native long nativeGetBalanceWithAddress(long subProxy, String address);
    private native void nativeAddCallback(long subProxy, ISubWalletCallback subCallback);
    private native void nativeRemoveCallback(long subProxy);
    private native String nativeCreateTransaction(long subProxy, String fromAddress, String toAddress, long amount, String memo, String remark);
    private native String nativeCreateMultiSignTransaction(long subProxy, String fromAddress, String toAddress, long amount, String memo);
    private native long nativeCalculateTransactionFee(long subProxy, String rawTransaction, long feePerKb);
	private native String nativeUpdateTransactionFee(long subProxy, String rawTransaction, long fee);
	private native String nativeSignTransaction(long subProxy, String rawTransaction, String payPassword);
	private native String nativeGetTransactionSignedSigners(long subProxy, String rawTransaction);
	private native String nativePublishTransaction(long subProxy, String rawTransaction);
    private native String nativeGetAllTransaction(long subProxy, int start, int count, String addressOrTxId);
    private native String nativeSign(long subProxy, String message, String payPassword);
    private native String nativeCheckSign(long subProxy, String publicKey, String message, String signature);
	private native String nativeGetPublicKey(long jSubProxy);
}