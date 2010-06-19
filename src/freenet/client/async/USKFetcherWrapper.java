/* This code is part of Freenet. It is distributed under the GNU General
 * Public License, version 2 (or at your option any later version). See
 * http://www.gnu.org/ for further details of the GPL. */
package freenet.client.async;

import com.db4o.ObjectContainer;

import freenet.client.FetchException;
import freenet.client.FetchResult;
import freenet.keys.FreenetURI;
import freenet.keys.USK;
import freenet.node.RequestClient;

/**
 * Wrapper for a backgrounded USKFetcher.
 */
public class USKFetcherWrapper extends BaseClientGetter {

	final USK usk;
	
	public USKFetcherWrapper(USK usk, short prio, RequestClient client) {
		super(prio, client);
		this.usk = usk;
	}

	@Override
	public FreenetURI getURI() {
		return usk.getURI();
	}

	@Override
	public boolean isFinished() {
		return false;
	}

	@Override
	public void notifyClients(ObjectContainer container, ClientContext context) {
		// Do nothing
	}

	public void onSuccess(FetchResult result, ClientGetState state, ObjectContainer container, ClientContext context) {
		// Ignore; we don't do anything with it because we are running in the background.
	}

	public void onFailure(FetchException e, ClientGetState state, ObjectContainer container, ClientContext context) {
		// Ignore
	}

	public void onBlockSetFinished(ClientGetState state, ObjectContainer container, ClientContext context) {
		// Ignore
	}

	@Override
	public void onTransition(ClientGetState oldState, ClientGetState newState, ObjectContainer container) {
		// Ignore
	}

	@Override
	public String toString() {
		return super.toString()+ ':' +usk;
	}

	public void onExpectedMIME(String mime, ObjectContainer container, ClientContext context) {
		// Ignore
	}

	public void onExpectedSize(long size, ObjectContainer container, ClientContext context) {
		// Ignore
	}

	public void onFinalizedMetadata(ObjectContainer container) {
		// Ignore
	}

	@Override
	public void cancel(ObjectContainer container, ClientContext context) {
		super.cancel();
	}

	@Override
	protected void innerToNetwork(ObjectContainer container, ClientContext context) {
		// Ignore
	}

	public void onExpectedTopSize(long size, long compressed, int blocksReq, int blocksTotal, ObjectContainer container, ClientContext context) {
		// Ignore
	}

	public void onSplitfileCompatibilityMode(long min, long max, ObjectContainer container, ClientContext context) {
		// Ignore
	}
}
