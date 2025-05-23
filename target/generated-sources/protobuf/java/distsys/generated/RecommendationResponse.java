// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: recommendation.proto

package distsys.generated;

/**
 * Protobuf type {@code distsys.RecommendationResponse}
 */
public final class RecommendationResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:distsys.RecommendationResponse)
    RecommendationResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RecommendationResponse.newBuilder() to construct.
  private RecommendationResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RecommendationResponse() {
    recommendations_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RecommendationResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return distsys.generated.RecommendationProto.internal_static_distsys_RecommendationResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return distsys.generated.RecommendationProto.internal_static_distsys_RecommendationResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            distsys.generated.RecommendationResponse.class, distsys.generated.RecommendationResponse.Builder.class);
  }

  public static final int RECOMMENDATIONS_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private com.google.protobuf.LazyStringList recommendations_;
  /**
   * <code>repeated string recommendations = 1;</code>
   * @return A list containing the recommendations.
   */
  public com.google.protobuf.ProtocolStringList
      getRecommendationsList() {
    return recommendations_;
  }
  /**
   * <code>repeated string recommendations = 1;</code>
   * @return The count of recommendations.
   */
  public int getRecommendationsCount() {
    return recommendations_.size();
  }
  /**
   * <code>repeated string recommendations = 1;</code>
   * @param index The index of the element to return.
   * @return The recommendations at the given index.
   */
  public java.lang.String getRecommendations(int index) {
    return recommendations_.get(index);
  }
  /**
   * <code>repeated string recommendations = 1;</code>
   * @param index The index of the value to return.
   * @return The bytes of the recommendations at the given index.
   */
  public com.google.protobuf.ByteString
      getRecommendationsBytes(int index) {
    return recommendations_.getByteString(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < recommendations_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, recommendations_.getRaw(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < recommendations_.size(); i++) {
        dataSize += computeStringSizeNoTag(recommendations_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getRecommendationsList().size();
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof distsys.generated.RecommendationResponse)) {
      return super.equals(obj);
    }
    distsys.generated.RecommendationResponse other = (distsys.generated.RecommendationResponse) obj;

    if (!getRecommendationsList()
        .equals(other.getRecommendationsList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getRecommendationsCount() > 0) {
      hash = (37 * hash) + RECOMMENDATIONS_FIELD_NUMBER;
      hash = (53 * hash) + getRecommendationsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static distsys.generated.RecommendationResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static distsys.generated.RecommendationResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static distsys.generated.RecommendationResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static distsys.generated.RecommendationResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static distsys.generated.RecommendationResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static distsys.generated.RecommendationResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static distsys.generated.RecommendationResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static distsys.generated.RecommendationResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static distsys.generated.RecommendationResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static distsys.generated.RecommendationResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static distsys.generated.RecommendationResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static distsys.generated.RecommendationResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(distsys.generated.RecommendationResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code distsys.RecommendationResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:distsys.RecommendationResponse)
      distsys.generated.RecommendationResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return distsys.generated.RecommendationProto.internal_static_distsys_RecommendationResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return distsys.generated.RecommendationProto.internal_static_distsys_RecommendationResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              distsys.generated.RecommendationResponse.class, distsys.generated.RecommendationResponse.Builder.class);
    }

    // Construct using distsys.generated.RecommendationResponse.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      recommendations_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return distsys.generated.RecommendationProto.internal_static_distsys_RecommendationResponse_descriptor;
    }

    @java.lang.Override
    public distsys.generated.RecommendationResponse getDefaultInstanceForType() {
      return distsys.generated.RecommendationResponse.getDefaultInstance();
    }

    @java.lang.Override
    public distsys.generated.RecommendationResponse build() {
      distsys.generated.RecommendationResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public distsys.generated.RecommendationResponse buildPartial() {
      distsys.generated.RecommendationResponse result = new distsys.generated.RecommendationResponse(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(distsys.generated.RecommendationResponse result) {
      if (((bitField0_ & 0x00000001) != 0)) {
        recommendations_ = recommendations_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.recommendations_ = recommendations_;
    }

    private void buildPartial0(distsys.generated.RecommendationResponse result) {
      int from_bitField0_ = bitField0_;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof distsys.generated.RecommendationResponse) {
        return mergeFrom((distsys.generated.RecommendationResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(distsys.generated.RecommendationResponse other) {
      if (other == distsys.generated.RecommendationResponse.getDefaultInstance()) return this;
      if (!other.recommendations_.isEmpty()) {
        if (recommendations_.isEmpty()) {
          recommendations_ = other.recommendations_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureRecommendationsIsMutable();
          recommendations_.addAll(other.recommendations_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();
              ensureRecommendationsIsMutable();
              recommendations_.add(s);
              break;
            } // case 10
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.LazyStringList recommendations_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureRecommendationsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        recommendations_ = new com.google.protobuf.LazyStringArrayList(recommendations_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string recommendations = 1;</code>
     * @return A list containing the recommendations.
     */
    public com.google.protobuf.ProtocolStringList
        getRecommendationsList() {
      return recommendations_.getUnmodifiableView();
    }
    /**
     * <code>repeated string recommendations = 1;</code>
     * @return The count of recommendations.
     */
    public int getRecommendationsCount() {
      return recommendations_.size();
    }
    /**
     * <code>repeated string recommendations = 1;</code>
     * @param index The index of the element to return.
     * @return The recommendations at the given index.
     */
    public java.lang.String getRecommendations(int index) {
      return recommendations_.get(index);
    }
    /**
     * <code>repeated string recommendations = 1;</code>
     * @param index The index of the value to return.
     * @return The bytes of the recommendations at the given index.
     */
    public com.google.protobuf.ByteString
        getRecommendationsBytes(int index) {
      return recommendations_.getByteString(index);
    }
    /**
     * <code>repeated string recommendations = 1;</code>
     * @param index The index to set the value at.
     * @param value The recommendations to set.
     * @return This builder for chaining.
     */
    public Builder setRecommendations(
        int index, java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      ensureRecommendationsIsMutable();
      recommendations_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string recommendations = 1;</code>
     * @param value The recommendations to add.
     * @return This builder for chaining.
     */
    public Builder addRecommendations(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      ensureRecommendationsIsMutable();
      recommendations_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string recommendations = 1;</code>
     * @param values The recommendations to add.
     * @return This builder for chaining.
     */
    public Builder addAllRecommendations(
        java.lang.Iterable<java.lang.String> values) {
      ensureRecommendationsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, recommendations_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string recommendations = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearRecommendations() {
      recommendations_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string recommendations = 1;</code>
     * @param value The bytes of the recommendations to add.
     * @return This builder for chaining.
     */
    public Builder addRecommendationsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      ensureRecommendationsIsMutable();
      recommendations_.add(value);
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:distsys.RecommendationResponse)
  }

  // @@protoc_insertion_point(class_scope:distsys.RecommendationResponse)
  private static final distsys.generated.RecommendationResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new distsys.generated.RecommendationResponse();
  }

  public static distsys.generated.RecommendationResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RecommendationResponse>
      PARSER = new com.google.protobuf.AbstractParser<RecommendationResponse>() {
    @java.lang.Override
    public RecommendationResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<RecommendationResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RecommendationResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public distsys.generated.RecommendationResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

