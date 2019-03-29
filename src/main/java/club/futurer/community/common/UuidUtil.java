package club.futurer.community.common;

import java.util.UUID;

public final class UuidUtil {
	public static String newUuidString() {
		UUID uuid = UUID.randomUUID();
		return Long.toHexString(uuid.getMostSignificantBits())
				+ Long.toHexString(uuid.getLeastSignificantBits());
	}
}
